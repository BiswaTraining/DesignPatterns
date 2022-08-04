package com.citiustech.Behavioural.MediatorPattern;

interface ChatMediator {

	public void sendMessage(String msg, ChatUser user);

	void addUser(ChatUser user);
}
