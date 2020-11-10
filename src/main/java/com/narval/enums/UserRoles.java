package com.narval.enums;

public enum UserRoles {
	ADMIN {
	    @Override
	    public String toString() {
	      return "Administrator";
	    }
	  },
	TURISTA {
	    @Override
	    public String toString() {
	      return "Turista";
	    }
	  },
	VINICOLA {
	    @Override
	    public String toString() {
	      return "Vinicola";
	    }
	  }
}
