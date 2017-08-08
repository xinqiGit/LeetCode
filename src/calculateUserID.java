	/**
	 *根据火车票不完整身份证号计算完整身份证号，计算完一般有30多个，需要最后确认（淘宝）。
	 */
	public static void main(String[] args) throws IOException {
		String s="4309022003****0516";
		List<String> li=traverseID(s);
		System.out.println(li.size());
		for (String l : li) {
			System.out.println(l);
		}
	}

	
	private static List<String> traverseID(String trainUserID){
		List<String> li=new ArrayList<String>();
		int count=0;
		String result;
		for(int i=1;i<=12;i++){			//1-12月
			for(int j=1;j<=31;j++){		//1-31日
				count++;
				String M="0"+i;
				if(M.length()>2){
					M=M.substring(1,3);
				}
				String D="0"+j;
				if(D.length()>2){
					D=D.substring(1,3);
				}
				result=trainUserID.substring(0,10)+M+D+trainUserID.substring(14,18);
				if(calculateID(result)){
					li.add(result);
				}
			}
		}
		return li;
	}
	
	private static boolean calculateID(String trainUserID){
		int W[]={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char A[]=trainUserID.substring(0, 17).toCharArray();
		int s=0;
		for(int i=0;i<=16;i++){
			//将1-17位对应的数据*对应的权值相加
			s=s+W[i]*Integer.valueOf(""+A[i]);
		}
		//取模
		int y=s%11;
		//取模之后余数对应的校验位的值
		Map<Integer, String> m=new HashMap<Integer, String>(11);
		m.put(0, "1");
		m.put(1, "0");
		m.put(2, "X");
		m.put(3, "9");
		m.put(4, "8");
		m.put(5, "7");
		m.put(6, "6");
		m.put(7, "5");
		m.put(8, "4");
		m.put(9, "3");
		m.put(10, "2");
		String end=trainUserID.substring(17);
		if(end.equals(m.get(y))){
			return true;
		}else{
			return false;
		}
	}