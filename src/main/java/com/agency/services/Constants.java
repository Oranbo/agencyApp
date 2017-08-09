package com.agency.services;
/**
 * 
 * @author BlackOrange
 * 常量
 *
 */
public interface Constants {
	//Strings relate to types
	String RENT = "出租";
	String SENT = "出售";
	String RENT_SENT = "出租/出售";
	
	
	//Strings relate to status
	String WAIT_RENT = "待租";
	String WAIT_SENT = "待售";
	String RENTED = "租出";
	String SENTED = "售出";
	
	//Strings relate to decoration
	String HIGH = "精装";
	String NORMAL = "平装";
	String LOW = "毛坯";
	
	//Strings relate to rent_types
	String ONE = "单间";
	String ALL = "整租";
	String JOIN = "合租";
	
	//Strings relate to sell_status
	String ONLINE = "上架中";
	String OFFLINE = "已下架";
	public enum enumUtil {  
	    rent(RENT, 1), sent(SENT, 2), rent_sent(RENT_SENT, 3),
		
	    wait_rent(WAIT_RENT,4),wait_sent(WAIT_SENT,5),rented(RENTED,6),
	    sented(SENTED,7),
	    
	    high(HIGH,8),normal(NORMAL,9),low(LOW,10),
	    
	    one(ONE,11),all(ALL,12),join(JOIN,13),
	    
		online(ONLINE,14),offline(OFFLINE,15);
	    
	    private String name;  
	    private int index;  
	      
	    private enumUtil(String name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }  
	      
	    public static String getName(int index) {  
	        for (enumUtil e : enumUtil.values()) {  
	            if (e.getIndex() == index) {  
	                return e.name;  
	            }  
	        }  
	        return null;  
	    }  
	      
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public int getIndex() {  
	        return index;  
	    }  
	    public void setIndex(int index) {  
	        this.index = index;  
	    }  
	} 
	
	
}
