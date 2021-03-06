package com.silverforge.elasticsearchrawclient.queryDSL.queries.innerQueries;

import com.silverforge.elasticsearchrawclient.exceptions.MandatoryParametersAreMissingException;
import com.silverforge.elasticsearchrawclient.model.QueryTypeItem;
import com.silverforge.elasticsearchrawclient.queryDSL.Constants;
import com.silverforge.elasticsearchrawclient.definition.MultiTermQueryable;
import com.silverforge.elasticsearchrawclient.queryDSL.generator.QueryFactory;
import com.silverforge.elasticsearchrawclient.queryDSL.queries.innerQueries.common.FieldValueQuery;
import com.silverforge.elasticsearchrawclient.utils.QueryTypeArrayList;

public class PrefixQuery
        extends FieldValueQuery implements MultiTermQueryable {

    private QueryTypeArrayList<QueryTypeItem> queryBag = new QueryTypeArrayList<>();

    PrefixQuery(QueryTypeArrayList<QueryTypeItem> queryBag) {
        this.queryBag = queryBag;
    }

    public static Init<?> builder() {
        return new PrefixQueryBuilder();
    }

    @Override
    public String getQueryString() {
        return QueryFactory
            .prefixQueryGenerator()
            .generate(queryBag);
    }

    public static class PrefixQueryBuilder
            extends Init<PrefixQueryBuilder> {

        @Override
        protected PrefixQueryBuilder self() {
            return this;
        }
    }

    public static abstract class Init<T extends Init<T>>
            extends FieldValueInit<T> {

        public T boost(int boost) {
            queryBag.addItem(Constants.BOOST, boost);
            return self();
        }

        public T boost(float boost) {
            queryBag.addItem(Constants.BOOST, boost);
            return self();
        }

        public PrefixQuery build() throws MandatoryParametersAreMissingException {
            if (!queryBag.containsKey(Constants.FIELD_NAME)) {
                throw new MandatoryParametersAreMissingException(Constants.FIELD_NAME);
            }
            if (!queryBag.containsKey(Constants.VALUE)) {
                throw new MandatoryParametersAreMissingException(Constants.VALUE);
            }
            return new PrefixQuery(queryBag);
        }
    }
}
