package com.revolver.entities;

public class ToppingCount {
	
	private Topping topping;
	
	private Integer count;

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ToppingCount [topping=" + topping + ", count=" + count + "]";
	}

}
