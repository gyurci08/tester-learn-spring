package hu.jandzsogyorgy.testerlearnspring.mapping;

import hu.jandzsogyorgy.testerlearnspring.dto.NodeDto;
import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.entity.Node;
import hu.jandzsogyorgy.testerlearnspring.entity.Vm;
import org.mapstruct.Mapper;


@Mapper(config = MappingConfig.class)
public interface NodeMapper extends GenericMapper<Node, NodeDto>,JsonMapper<Node> {
    @Override
    default Class<Node> getEntityClass() {
        return Node.class;
    }
}
