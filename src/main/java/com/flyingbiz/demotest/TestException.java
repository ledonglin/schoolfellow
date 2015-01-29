package com.flyingbiz.demotest;

public class TestException {
	public TestException() {
	}

	boolean testEx() throws Exception {
		boolean ret = true;
		try {
			ret = testEx1();
		} catch (Exception e) {
			System.out.println("testEx, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx, finally; return value=" + ret);
			return ret;
		}
	}

	boolean testEx1() throws Exception {
		boolean ret = true;
		try {
			ret = testEx2();
			if (!ret) {
				return false;
			}
			System.out.println("testEx1, at the end of try");
			return ret;
		} catch (Exception e) {
			System.out.println("testEx1, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx1, finally; return value=" + ret);
			return ret;
		}
	}

	boolean testEx2() throws Exception {
		boolean ret = true;
		try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / i;
				System.out.println("i=" + i);
			}
			return true;
		} catch (Exception e) {
			System.out.println("testEx2, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx2, finally; return value=" + ret);
			return ret;  /*因为有这个return，将抛弃catch块中抛出的异常。 如果没有这条语句，调用方法就能收到catch抛出的异常*/
		}
	}
/*
	public static void main(String[] args) {
		TestException testException1 = new TestException();
		try {
			testException1.testEx();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
	
	 public static void main(String args[]) {  
	        int i = 0;  
	        String greetings[] = { " Hello world !", " Hello World !! ",  
	                " HELLO WORLD !!!" };  
	        while (i < 4) {  
	            try {  
	                // 特别注意循环控制变量i的设计，避免造成无限循环  
	                System.out.println(greetings[i++]);	//如果此处换成 system.out.println(greetings[i]); i++; 将会导致死循环
	            } catch (ArrayIndexOutOfBoundsException e) {  
	                System.out.println("数组下标越界异常");  
	            } finally {  
	                System.out.println("--------------------------");  
	            }  
	        }  
	    } 
}