package ru.abstractmenus.hocon.impl;

import java.util.Collection;

final class ConfigNodeConcatenation extends ConfigNodeComplexValue {
    ConfigNodeConcatenation(Collection<AbstractConfigNode> children) {
        super(children);
    }

    @Override
    protected ConfigNodeConcatenation newNode(Collection<AbstractConfigNode> nodes) {
        return new ConfigNodeConcatenation(nodes);
    }
}
