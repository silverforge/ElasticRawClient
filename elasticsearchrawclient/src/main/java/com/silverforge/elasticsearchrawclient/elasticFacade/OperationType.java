package com.silverforge.elasticsearchrawclient.elasticFacade;

import java.util.HashMap;

/**
 * Types of the ElasticSearch operations
 */
public enum OperationType {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    INDEX("INDEX"),
    QUERY("QUERY"),
    SEARCH("SEARCH");

    private static final HashMap<String, String> operationPathType = new HashMap<>();
    static {
        operationPathType.put("CREATE", "_create");
        operationPathType.put("UPDATE", "_update");
        operationPathType.put("DELETE", "");
        operationPathType.put("INDEX", "");
        operationPathType.put("QUERY", "_query");
        operationPathType.put("SEARCH", "_search");
    }

    private String operationType;

    OperationType(String operationType) {

        this.operationType = operationType;
    }

    /**
     * Override of the toString
     * @return the operationtype, e.g.: "CREATE", "UPDATE", "DELETE", "INDEX", "QUERY", "SEARCH"
     */
    @Override
    public String toString() {
        return operationType;
    }

    /**
     * Retrieves with the operation path
     * @return the operation type path, e.g.: "_create", "_update", "_query", "_search"
     */
    public String getOperationTypePath() {
        return operationPathType.get(operationType);
    }
}
