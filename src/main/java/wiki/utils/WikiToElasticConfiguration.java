/**
 * @author  Alon Eirew
 */

package wiki.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class WikiToElasticConfiguration {

    private final static Logger LOGGER = LogManager.getLogger(WikiToElasticConfiguration.class);

    public static final Type CONFIGURATION_TYPE = new TypeToken<WikiToElasticConfiguration>() {}.getType();
    public static final Gson gson = new Gson();

    private String indexName;
    private String docType;
    private String mapping;
    private String setting;
    private String host;
    private String scheme;
    private String wikiDump;
    private int port;
    private int shards;
    private int replicas;
    private int insertBulkSize;
    private boolean normalizeFields;

    private transient String mappingFileContent = null;
    private transient String settingFileContent = null;

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getShards() {
        return shards;
    }

    public void setShards(int shards) {
        this.shards = shards;
    }

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    public String getWikiDump() {
        return wikiDump;
    }

    public void setWikiDump(String wikiDump) {
        this.wikiDump = wikiDump;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public int getInsertBulkSize() {
        return insertBulkSize;
    }

    public void setInsertBulkSize(int insertBulkSize) {
        this.insertBulkSize = insertBulkSize;
    }

    public boolean isNormalizeFields() {
        return normalizeFields;
    }

    public void setNormalizeFields(boolean normalizeFields) {
        this.normalizeFields = normalizeFields;
    }

    public String getMappingFileContent() {
        if(this.mappingFileContent == null && this.mapping != null) {
            this.mappingFileContent = WikiToElasticUtils.getFileContent(this.mapping);
        }
        return this.mappingFileContent;
    }

    public String getSettingFileContent() {
        if(this.settingFileContent == null && this.setting != null) {
            this.settingFileContent = WikiToElasticUtils.getFileContent(this.setting);
        }
        return this.settingFileContent;
    }
}
