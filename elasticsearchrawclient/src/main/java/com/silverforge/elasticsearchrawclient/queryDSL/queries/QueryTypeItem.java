package com.silverforge.elasticsearchrawclient.queryDSL.queries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryTypeItem {
    private String name;
    private String value;
    private boolean isParent;
}
