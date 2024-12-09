package hu.jandzsogyorgy.testjdbc.mapping;

public interface GenericMapper<E, D> extends DtoMapper<E, D>, EntityMapper<E, D> {
}
