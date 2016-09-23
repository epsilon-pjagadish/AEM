package com.citraining.core.utils;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.InvalidQueryException;
import javax.jcr.query.QueryManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

public class SearchUtils {

	private static final Logger LOGGER=LoggerFactory.getLogger(SearchUtils.class);
	private SearchUtils(){
		
	}
	private static QueryManager getQueryManger(final Session session){
		try {
			return session.getWorkspace().getQueryManager();
		} catch (RepositoryException e) {
			LOGGER.error("cannot get the query object return null{}",e);
		}
		return null;
	}
	public static String[] getSupportedQueryLanguage(final Session session){
		try {
			QueryManager qm=getQueryManger(session);
			return qm.getSupportedQueryLanguages();
		} catch (RepositoryException e) {
			LOGGER.error("error is {}",e);
		}
		return null;
	}
	public static String getLastMoidifedPage(final Session session,String path,String template){
		String sqlStatement="SELECT parent.* FROM [cq:Page] AS parent INNER JOIN [nt:base] AS child ON ISCHILDNODE(child,parent) WHERE ISDESCENDANTNODE(parent, '"+path+"')"
				+ " AND child.[cq:template] = '"+template+"' "
						+ "ORDER BY child.[cq:lastModified] desc";
		QueryManager qm=getQueryManger(session);
		try {
			javax.jcr.query.Query query = qm.createQuery(sqlStatement,"JCR-SQL2");
			javax.jcr.query.QueryResult result = query.execute();
			javax.jcr.NodeIterator nodeIter = result.getNodes();
			//SearchResult result1 = query.getResult();
			if(nodeIter.hasNext()){
			Node mynoed=(Node)nodeIter.next();
				//if(mynoed.hasProperty("jcr:title")){
				return mynoed.getName();
			//}
				}
		} catch (InvalidQueryException e) {			
			e.printStackTrace();
		} catch (RepositoryException e) {			
			e.printStackTrace();
		}
		 
		
		return null;
	}
	
}
