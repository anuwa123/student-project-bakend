package com.ABC.Student.registration.dto.parameters;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchParameter {
    private int page=0;
    private int size=10;

    public int getPage() {
        if (page<0) return 0;
        return page;
    }

    public int getSize() {
        if (size<=0) return 10;
        return size;
}
}

