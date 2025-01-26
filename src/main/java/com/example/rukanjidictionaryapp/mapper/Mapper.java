package com.example.rukanjidictionaryapp.mapper;

public interface Mapper<TEntity, TDto>  {
    public TDto toDto(TEntity entity);
    public TEntity toEntity(TDto dto);
}