package com.platon.browser.exception;

/**
 *
 * @Auther: Chendongming
 * @Date: 2019/8/17 16:27
 * @Description: 结算周期切换异常
 */
public class SettleEpochChangeException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SettleEpochChangeException(String msg){
        super(msg);
    }
}
