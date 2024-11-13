package Observer;

import Observable.StockObservable;

public class MailNotificationAlertObserver  implements NotificationAlertObserver{
	
	public String mail;
	public StockObservable stockObservable;


	public MailNotificationAlertObserver(String mail,StockObservable stockObservable) {
		this.stockObservable=stockObservable;
		this.mail=mail;
	}

	@Override
	public void update() {
		System.out.println(mail+" product is in stock hurry up");
	}
	
	public void sendMail() {
		System.out.println("mail sent to: "+mail);
	}

}
