package sen3004.project.model;

import javax.validation.constraints.NotEmpty;

public class SearchEngine {
	
	private String searchedItem;
	
	@NotEmpty
	private String type;

	public String getSearchedItem() {
		return searchedItem;
	}

	public void setSearchedItem(String searchedItem) {
		this.searchedItem = searchedItem;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
