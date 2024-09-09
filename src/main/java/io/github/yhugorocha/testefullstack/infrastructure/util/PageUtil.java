package io.github.yhugorocha.testefullstack.infrastructure.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageUtil {

    public Page<?> adicionaPaginacao(List<?> list, Integer pageNumber, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        List<?> subList = list.subList(start, end);

        return new PageImpl<>(subList, pageable, list.size());
    }
}
