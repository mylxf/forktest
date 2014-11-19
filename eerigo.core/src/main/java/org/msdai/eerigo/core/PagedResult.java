package org.msdai.eerigo.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/1/14
 * Time: 2:55 PM
 */
public class PagedResult<T> implements Collection<T>, Iterable<T> {

    public static final PagedResult EMPTY = new PagedResult();

    private Integer totalRecords;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageIndex;
    private List<T> data;

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public List<T> getData() {
        return data;
    }

    public PagedResult() {
        this.data = new ArrayList<T>();
    }

    public PagedResult(int totalRecords, int totalPages, int pageSize, int pageIndex, List<T> data) {
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (this == obj || obj instanceof PagedResult && totalPages.equals(((PagedResult) obj).totalPages) && totalRecords.equals(((PagedResult) obj).totalRecords) && pageIndex.equals(((PagedResult) obj).pageIndex) && pageSize.equals(((PagedResult) obj).pageSize) && data == ((PagedResult) obj).data);

    }

    @Override
    public int hashCode() {
        return totalPages.hashCode() ^ totalRecords.hashCode() ^ pageIndex.hashCode() ^ pageSize.hashCode() ^ data.hashCode();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return data.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public void clear() {
        data.clear();
    }
}
