
class Human implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    
    public Human() {
    }
    
    public Human(String name) {
    	this.name = name;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}
