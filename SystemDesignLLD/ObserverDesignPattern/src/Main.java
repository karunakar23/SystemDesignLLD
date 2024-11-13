import Observable.AndriodPhoneObservable;
import Observable.IphoneObservable;
import Observable.StockObservable;
import Observer.MailNotificationAlertObserver;
import Observer.MessageNotificationAlertObserver;
import Observer.NotificationAlertObserver;

/*
 * In Amazon app we have notify button when a product is out of stock when the product has stock then message
 * will be send to the user that stock is there hurry up to buy and there will be millions of customers 
 * who clicked that button how this will work in real world application like amazon or flipkart this 
 * will be done by using Observer Design Pattern more info coding and concept You tube System design course
 */






public class Main {

	public static void main(String[] args) {
		
		StockObservable AndroidPhoneStock=new AndriodPhoneObservable();
		NotificationAlertObserver aobs1= new MailNotificationAlertObserver("XYZ@gmail.com",AndroidPhoneStock);
		NotificationAlertObserver aobs2= new MailNotificationAlertObserver("ABC@gmail.com",AndroidPhoneStock);
		NotificationAlertObserver aobs3= new MessageNotificationAlertObserver(123456789,AndroidPhoneStock);
		AndroidPhoneStock.add(aobs1);
		AndroidPhoneStock.add(aobs2);
		AndroidPhoneStock.add(aobs3);
		AndroidPhoneStock.setStockCount(20);
		
		StockObservable iphoneObservable=new IphoneObservable();
		NotificationAlertObserver aobs4= new MailNotificationAlertObserver("IphoneXYZ@gmail.com",iphoneObservable);
		NotificationAlertObserver aobs5= new MailNotificationAlertObserver("IphoneABC@gmail.com",iphoneObservable);
		NotificationAlertObserver aobs6= new MessageNotificationAlertObserver(1234,iphoneObservable);
		iphoneObservable.add(aobs4);
		iphoneObservable.add(aobs5);
		iphoneObservable.add(aobs6);
		iphoneObservable.setStockCount(20);
	}

}
