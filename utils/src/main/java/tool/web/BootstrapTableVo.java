package tool.web;

import java.io.Serializable;

/**
 * @Auther: zch
 * @Date: 2018/8/26 09:42
 * @Description:
 */
public class BootstrapTableVo<E> implements Serializable {
    /*总页数*/
    private Long total;
    //当前页
    private int pageSize;
    /**总记录**/
    private long pageTotal;
    //每页的最大记录数
    public final int PAGE_MAX = 10;
    private E rows;

    public BootstrapTableVo(){}

    public BootstrapTableVo(Long total, E rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        if (getPageTotal() <= PAGE_MAX)return 1l;
        long temp = (pageTotal/PAGE_MAX);
        if ((pageTotal % PAGE_MAX ) == 0 ){
            return temp;
        }else {
            return temp+1;
        }
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public E getRows() {
        return rows;
    }

    public void setRows(E rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }
}
