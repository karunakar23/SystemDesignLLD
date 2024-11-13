package Observer;

import Observable.StockObservable;

public class MessageNotificationAlertObserver implements NotificationAlertObserver {
	
	public int nmbr;
	public StockObservable stockObservable;
	
	
	public MessageNotificationAlertObserver(int nmbr,StockObservable stockObservable) {
		this.nmbr=nmbr;
		this.stockObservable=stockObservable;
	}


	@Override
	public void update() {
		System.out.println(nmbr+ " product is there hurry up");
		
	}
	
	public void sendMessage() {
		System.out.println("Message Sent to: "+nmbr);
	}
	
	

}
