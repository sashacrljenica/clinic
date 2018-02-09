package model;

public class Pharmacy {
	private int pharmacyID;
	private String nameOfTheDrug, scopeOfApplication;
	private int quantityOnCondition;
	private String note;
	private Manufacturer manufacturer;

	public int getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(int pharmacyID) {
		this.pharmacyID = pharmacyID;
	}

	public String getNameOfTheDrug() {
		return nameOfTheDrug;
	}

	public void setNameOfTheDrug(String nameOfTheDrug) {
		this.nameOfTheDrug = nameOfTheDrug;
	}

	public String getScopeOfApplication() {
		return scopeOfApplication;
	}

	public void setScopeOfApplication(String scopeOfApplication) {
		this.scopeOfApplication = scopeOfApplication;
	}

	public int getQuantityOnCondition() {
		return quantityOnCondition;
	}

	public void setQuantityOnCondition(int quantityOnCondition) {
		this.quantityOnCondition = quantityOnCondition;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
