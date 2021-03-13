package ml.nkqnkq.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    public static PageResultUtils getPageResult(Page pageRequest, PageInfo<?> pageInfo) {
        PageResultUtils pageResult = new PageResultUtils();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}