package com.citraining.core.models;
/*
import javax.annotation.Nonull;
import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Title;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;

@Model (adaptables = SlingHttpServletRequest.class, adapters = { Title.class, ComponentExporter.class }, resourceType = TitleImpl.RESOURCE_TYPE)
@Exporter (name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TitleImpl implements Title, ComponentExporter {

	protected static final String RESOURCE_TYPE = "core/wcm/components/title/v1/title";

	@ScriptVariable
	private Resource resource;

	@ScriptVariable
	private Page currentPage;

	@ScriptVariable
	private Style currentStyle;

	@ValueMapValue (optional = true, name = JcrConstants.JCR_TITLE)
	private String title;

	@ValueMapValue (optional = true)
	private String type;
*/
	/**
	 * The {@link Heading} object for the type of this title.
	 */
/*	private Heading heading;

	@PostConstruct
	private void initModel() {
		if (StringUtils.isBlank(title)){
			title = StringUtils.defaultIfEmpty(currentPage.getPageTitle(), currentPage.getTitle());
		}

		if (heading == null){
			heading = Heading.getHeading(type);
			if (heading == null){
				heading = Heading.getHeading(currentStyle.get(PN_DESIGN_DEFAULT_TYPE, String.class));
			}
		}
	}

	@Override
	public String getText() {
		return title;
	}

	@Override
	public String getType() {
		if (heading != null){
			return heading.getElement();
		}
		return null;
	}

	@Nonnull
	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	private enum Heading {

		H1 ("h1"), H2 ("h2"), H3 ("h3"), H4 ("h4"), H5 ("h5"), H6 ("h6");

		private String element;

		Heading(String element) {
			this.element = element;
		}

		private static Heading getHeading(String value) {
			for (Heading heading : values()){
				if (StringUtils.equalsIgnoreCase(heading.element, value)){
					return heading;
				}
			}
			return null;
		}

		public String getElement() {
			return element;
		}
	}

}
*/