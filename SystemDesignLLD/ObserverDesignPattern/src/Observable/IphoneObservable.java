package Observable;

import java.util.ArrayList;
import java.util.List;

import Observer.NotificationAlertObserver;

public class IphoneObservable  implements StockObservable{
	int stockCount=0;
	List<NotificationAlertObserver> list=new ArrayList<>();

	@Override
	public void add(NotificationAlertObserver observer) {
		list.add(observer);	
	}

	@Override
	public void remove(NotificationAlertObserver observer) {
		list.remove(observer);
	}

	@Override
	public void notifySubscribers() {
		for(NotificationAlertObserver ob:list){
			ob.update();
		}
		
	}

	@Override
	public void setStockCount(int newStockAdded) {
		if(stockCount==0 && newStockAdded>0) {
			notifySubscribers();
		}
		stockCount+=newStockAdded;
	}

	@Override
	public int getStockCount() {
		return stockCount;
	}

}
