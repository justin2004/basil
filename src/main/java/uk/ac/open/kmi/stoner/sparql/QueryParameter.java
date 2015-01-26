package uk.ac.open.kmi.stoner.sparql;

import java.io.Serializable;

public class QueryParameter implements Serializable {

	public enum Type{
		IRI, TypedLiteral, LangedLiteral, PlainLiteral, Mixed
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6725251315049248905L;
	private String name;
	private String lang = null;
	private boolean isOptional;
	private String datatype = null;
	private Type type = null;
	
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public boolean isForcedIri() {
		return type == Type.IRI;
	}

	void setForcedIri() {
		this.type = Type.IRI;
		//
		this.datatype = null;
		this.lang = null;
	}

	public boolean isForcedPlainLiteral() {
		return type == Type.PlainLiteral;
	}

	public boolean isForcedLangedLiteral() {
		return type == Type.LangedLiteral;
	}

	public boolean isForcedTypedLiteral() {
		return type == Type.TypedLiteral;
	}

	public boolean isMixed() {
		return type == Type.Mixed;
	}

	void setMixed() {
		this.type = Type.Mixed;

		this.datatype = null;
		this.lang = null;
	}

	public String getLang() {
		return lang;
	}

	void setLang(String lang) {
		this.lang = lang;
		this.type = Type.LangedLiteral;
		//
		this.datatype = null;
	}

	public boolean isOptional() {
		return isOptional;
	}

	void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}

	public String getDatatype() {
		return datatype;
	}

	void setDatatype(String datatype) {
		this.datatype = datatype;
		this.type = Type.TypedLiteral;
		//
		this.lang = null;
	}

	public void setForcedPlainLiteral() {
		this.type = Type.PlainLiteral;
		//
		this.datatype = null;
		this.lang = null;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof QueryParameter) &&
				(((QueryParameter)obj).type.equals(this.type)) &&
				(((QueryParameter)obj).getName().equals(this.getName()));
	}
}