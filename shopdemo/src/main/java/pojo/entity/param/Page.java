package pojo.entity.param;

import java.util.List;

public class Page<T> {


    private List<T> data;


    private int pageSize;


    private int pageIndex;

    private int pages;

    private int total;


    public Page(List<T> data, int pageIndex, int pageSize) {


        this.data = getDataList(data);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pages = getPageNumber();
        this.total = data.size();
    }

    public Page() {
    }

    private int getPageNumber() {

        int num = 0;

        if (pageSize > total) {

            return 1;
        } else {

            num = total % pageSize;
            num += total % pageSize == 0 ? 0 : 1;
        }

        return num;
    }

    private List<T> getDataList(List<T> data) {

        if (total != 0) {

            int head = Math.min(Math.max(pageSize * (pageIndex - 1), 0), data.size());
            int tail = Math.min(Math.max(pageSize * pageIndex, head), data.size());

            return data.subList(head, tail);
        }

        return data;

    }


}
