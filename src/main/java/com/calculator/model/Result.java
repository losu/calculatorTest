package com.calculator.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Result {

	private Double result;

	public Result() {
	}

	public Result(Double result) {
		this.result = result;
	}

	public Double getResult() {
		return this.result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37)
				.append(result)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Result that = (Result) obj;
		
		return new EqualsBuilder()
				.append(result, that.result)
				.build();
	}

}
