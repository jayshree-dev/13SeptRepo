package com.jbk;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	
		
	

	@Override
	public void onTestFailure(ITestResult Ress) {
		// TODO Auto-generated method stub
		String Result =Ress.getName();
		Write write=new Write();
		
			try {
				write.WriteResult(Result, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult Ress) {
		// TODO Auto-generated method stub
		String Result =Ress.getName();
		Write write=new Write();
		
			try {
				write.WriteResult(Result, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult Ress) {
		// TODO Auto-generated method stub
		String Result =Ress.getName();
		Write write=new Write();
		
			try {
				write.WriteResult(Result, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
