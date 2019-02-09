package rpc.hessian;

import java.io.Serializable;

public class User implements  Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

}
