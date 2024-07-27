package Model;

public class TopBooks {
	 private String bookName;
	    private Long count;

	    public TopBooks(String bookName, Long count) {
	        this.bookName = bookName;
	        this.count = count;
	    }

	    public String getBookName() {
	        return bookName;
	    }

	    public void setBookName(String bookName) {
	        this.bookName = bookName;
	    }

	    public Long getCount() {
	        return count;
	    }

	    public void setCount(Long count) {
	        this.count = count;
	    }
	 
}
