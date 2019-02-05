package me.nickimpact.gts.api.holders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nickimpact.gts.api.listings.entries.Entry;
import me.nickimpact.gts.api.listings.entries.EntryUI;

@Getter
@AllArgsConstructor
public class EntryClassification {
	/** Represents the classification of an entry */
	private Class<? extends Entry> classification;

	/** Represents the identifiable name for an entry classification */
	private String identifer;

	/** Represents the item type that will serve as the representation for this classification */
	private String itemRep;

	/** Represents the UI that'll be used to handle necessary functionality of the selling operations */
	private EntryUI ui;
}
