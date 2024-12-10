package hu.jandzsogyorgy.testerlearnspring.mapping;

public interface GenericMapper<E, D> extends DtoMapper<E, D>, EntityMapper<E, D> {
}
