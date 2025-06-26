package com.create;

	class User {
	    private String name;
	    private String borrowedBook;

	    public User(String name) {
	        this.name = name;
	        this.borrowedBook = null;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getBorrowedBook() {
	        return borrowedBook;
	    }

	    public void setBorrowedBook(String borrowedBook) {
	        this.borrowedBook = borrowedBook;
	    }
	}

