import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCriteria {

	List<String> region = Arrays.asList(new String[]{"TARA ROMANEASCA", "MOLDOVA", "BASARABIA","TRANSILVANIA", "DOBROGEA"});
	List<String> keyReg = Arrays.asList(new String[]{"domnit", "voievod"});
	List<String> timeRef = Arrays.asList(new String[]{"anii"});

	String zona;
	List<Ani> domnie;
	List<Ani> viata;
	boolean checkDomnie ;
	boolean checkViata ;
	boolean checkD ;
	
	public void setIndicatorDomFalse() {
		checkD = false;
	}
	public void setIndicatorDomnieFalse() {
		checkDomnie = false;
	}
	public void setIndicatorViataFalse() {
		checkViata = false;
	}
	
	public void SetDomnie(ArrayList<String> ani) {
		
	}
	
	public void setRegion(String reg) {
		zona = reg;
	}
	
	public void processWord(String word, SearchCriteria sc){
		if(keyReg.contains(word)) {
			checkD = true;
		}
		else if(timeRef.contains(word)) {
			checkDomnie = true;
		}
		else if(region.contains(word.toUpperCase())){
	        sc.setRegion(word.toUpperCase());
	        return;
	    }
		else if(checkDomnie == true && checkD == true) {
	    	System.out.println(word);
	    	int start;
	    	int stop;
	    	
	    	if(word.equals("si")) {
	    		
	    	}
	    	else if(word.contains("-")) {
	    		String[] s = word.split("-");
	    		start = Integer.parseInt(s[0]);
	    		stop = Integer.parseInt(s[1]);
	    		System.out.println("Anii sunt: " + start + "-" + stop);
	    		return;
	    	}else {
	    		if(word.contains(".")) {
	    			word = word.replace(".", "");
	    		}
	    		int an;
	    		try {
	    			an = Integer.parseInt(word);
	    		} catch (NumberFormatException e) {
	    			System.out.println("Wrong format");
	    			an = 0;
	    		}
	    		if(an != 0) {
	    			System.out.println("anul este " + an);
	    		}
	    		return;
	    	}
	    }

	}
	
}
