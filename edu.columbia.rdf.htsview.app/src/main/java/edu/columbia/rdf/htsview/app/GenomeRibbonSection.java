/**
 * Copyright 2016 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.columbia.rdf.htsview.app;

import org.jebtk.bioinformatics.genomic.GenesService;
import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.bioinformatics.ui.GenomeModel;
import org.jebtk.modern.UI;
import org.jebtk.modern.UIService;
import org.jebtk.modern.event.ModernClickEvent;
import org.jebtk.modern.event.ModernClickListener;
import org.jebtk.modern.graphics.icons.ModernIcon;
import org.jebtk.modern.menu.ModernPopupMenu;
import org.jebtk.modern.menu.ModernTwoLineMenuItem;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.ribbon.RibbonLargeDropDownButton;
import org.jebtk.modern.ribbon.RibbonSection;
import org.jebtk.modern.ribbon.RibbonSize;



// TODO: Auto-generated Javadoc
/**
 * Allows user to select the resolution to view sequences.
 *
 * @author Antony Holmes Holmes
 */
public class GenomeRibbonSection extends RibbonSection implements ModernClickListener {
	
	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The Constant ICON. */
	private static final ModernIcon ICON = 
			UIService.getInstance().loadIcon("genome", 24);

	/**
	 * The m human button.
	 */
	//private RibbonLargeRadioButton mHumanButton = new RibbonLargeRadioButton("Human", 
	//				UIService.getInstance().loadIcon("human", 24));
	
	/**
	 * The m mouse button.
	 */
	//private RibbonLargeRadioButton mMouseButton = new RibbonLargeRadioButton("Mouse", 
	//		UIService.getInstance().loadIcon("mouse_dark", 24));
	

	/**
	 * The m model.
	 */
	private GenomeModel mModel;

	/** The m button. */
	private RibbonLargeDropDownButton mButton;

	/**
	 * Instantiates a new genome ribbon section.
	 *
	 * @param ribbon the ribbon
	 * @param model the model
	 */
	public GenomeRibbonSection(Ribbon ribbon, GenomeModel model) {
		super(ribbon, "Genome");
		
		mModel = model;
		
		//ModernButtonGroup group = new ModernButtonGroup();
		
		ModernPopupMenu popup = new ModernPopupMenu();
		
		for (String genome : CollectionUtils.sort(GenesService.getInstance().getGenomes())) {
			popup.addMenuItem(new ModernTwoLineMenuItem(genome, 
					"Switch to the " + genome + " genome.", 
					ICON));
		}
		
		
		
		
		mButton = new RibbonLargeDropDownButton("Genome", popup)
				.setMinWidth(RibbonSize.COMPACT, 72);
		mButton.setToolTip("Genome", "Change the genome reference.");
		add(mButton);
		
		mButton.addClickListener(this);
		
		mButton.setText(mModel.get());
		
		//mHumanButton.setToolTip("Human", "Human Genome Mode.");
		//mHumanButton.setShowText(false);
		//add(mHumanButton);
		
		//mMouseButton.setToolTip("Mouse", "Mouse Genome Mode.");
		//mMouseButton.setShowText(false);
		//add(mMouseButton);
		
		
		

		//group.add(mHumanButton);
		//group.add(mMouseButton);

		//mHumanButton.addClickListener(this);
		//mMouseButton.addClickListener(this);

		//if (mModel.get().equals(GenomeAssembly.MM10)) {
		//	mMouseButton.setSelected(true);
		//} else {
		//	mHumanButton.setSelected(true);
		//}
	}
	
	/**
	 * Change.
	 *
	 * @param e the e
	 */
	private void change(ModernClickEvent e) {
		//if (mHumanButton.isSelected()) {
		//	mModel.set(GenomeAssembly.HG19);
		//} else if (mMouseButton.isSelected()) {
		//	mModel.set(GenomeAssembly.MM10);
		//} else {
		//	
		//}
		
		mModel.set(e.getMessage());
	}

	/* (non-Javadoc)
	 * @see org.abh.common.ui.ui.event.ModernClickListener#clicked(org.abh.common.ui.ui.event.ModernClickEvent)
	 */
	@Override
	public void clicked(ModernClickEvent e) {
		change(e);
	}
}
