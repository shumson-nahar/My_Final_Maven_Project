package program;

public class Binary {
	public int bSearch(int araylist[], int searchElem) {
	      int l = 0;
	      int h = araylist.length - 1;
	      while(l <= h) {
	         int mid = (l + h) / 2;
	         if(araylist[mid] == searchElem) {
	            return mid;
	         }
	         if(araylist[l] <= araylist[mid]) {
	            if(searchElem >= araylist[l] && searchElem < araylist[mid]) {
	               h = mid - 1;
	            } else {
	               l = mid + 1;
	            } 
	         } else {
	            if(searchElem > araylist[mid] && searchElem <= araylist[h]) {
	               l = mid + 1;
	            } else {
	               h = mid - 1;
	            }
	         }
	      }
	      return -1;
	   }
	   public static void main(String[] args) {
	      int araylist[] = {87, 89, 93, 0, 2, 5, 19};
	      int searchElem = 2;
	      Binary obj = new Binary(); 
	      // object creation 
	      System.out.println("The given element is available at index: " + obj.bSearch(araylist, searchElem)); 
	      // calling method with arguments
	   }
	}


