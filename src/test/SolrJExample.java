package test;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.net.MalformedURLException;

public class SolrJExample {
  public static void main(String[] args) throws MalformedURLException, SolrServerException {
    SolrServer solr = new CommonsHttpSolrServer("http://localhost:8080/solr/campaignCore");

    // http://localhost:8983/solr/spellCheckCompRH?q=epod&spellcheck=on&spellcheck.build=true
    ModifiableSolrParams params = new ModifiableSolrParams();
    params.set("qt", "/spellCheckCompRH");
    params.set("q", "epod");
    params.set("spellcheck", "on");
    params.set("spellcheck.build", "true");

    QueryResponse response = solr.query(params);
    System.out.println("response = " + response);
  }
}