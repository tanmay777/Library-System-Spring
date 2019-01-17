package com.example.library_system.convertors;

import com.example.library_system.bos.BookBoModel;
import com.example.library_system.entities.BookEntityModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntityModel bookBoModelToBookEntityModel(BookBoModel bookBoModel);

    BookBoModel bookEntityModelToBookBoModel(BookEntityModel bookEntityModel);

}
