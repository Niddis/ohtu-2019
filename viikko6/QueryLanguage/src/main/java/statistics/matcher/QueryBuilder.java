
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    List<Matcher> matchers;
    Matcher endMatcher;
    
    public QueryBuilder() {
        this.matchers = new ArrayList<>();
        this.endMatcher = null;
    }
    
    public Matcher build() {
        if (matchers.isEmpty()) {
            matchers.add(new All());
        }
        if (endMatcher == null) {
            endMatcher = new And(matchers.toArray(new Matcher[matchers.size()]));
        }
        Matcher m = endMatcher;
        matchers.clear();
        endMatcher = null;

        return m;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.endMatcher = new Or(matchers);
        return this;
    }
}
