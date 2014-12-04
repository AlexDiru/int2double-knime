package org.alexdiru.inttodouble;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "Int2Double" Node.
 * 
 *
 * @author Alex Spedding
 */
public class Int2DoubleNodeFactory 
        extends NodeFactory<Int2DoubleNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Int2DoubleNodeModel createNodeModel() {
        return new Int2DoubleNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeView<Int2DoubleNodeModel> createNodeView(final int viewIndex,
            final Int2DoubleNodeModel nodeModel) {
        return new Int2DoubleNodeView(nodeModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasDialog() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeDialogPane createNodeDialogPane() {
        return new Int2DoubleNodeDialog();
    }

}

