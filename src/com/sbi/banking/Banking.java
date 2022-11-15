package com.sbi.banking;

public abstract class Banking {
	
	abstract int withdrawMoney(int bal);
	abstract int dipositMoney(int bal);
	abstract void statement(String acc,String stm1,String stm2,String stm3,String stm4);
	
	}
