package org.alexdiru.inttodouble;

import java.io.File;
import java.io.IOException;

import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.DataType;
import org.knime.core.data.container.CloseableRowIterator;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;

/**
 * This is the model implementation of Int2Double.
 * 
 *
 * @author Alex Spedding
 */
public class Int2DoubleNodeModel extends NodeModel {
    
    /**
     * Constructor for the node model.
     */
    protected Int2DoubleNodeModel() {
    
        // TODO: Specify the amount of input and output ports needed.
        super(1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
            final ExecutionContext exec) throws Exception {
    	
    	int numCols = inData[0].getDataTableSpec().getNumColumns();
    	
    	DataColumnSpec[] specs = new DataColumnSpec[numCols];
   
    	for (int i = 0; i < numCols; i++) {
    		
    		if (inData[0].getDataTableSpec().getColumnSpec(i).getType().toString().equals("IntCell")) {
    			String name = inData[0].getDataTableSpec().getColumnNames()[i];
    			DataColumnSpecCreator creator = new DataColumnSpecCreator(name, DataType.getType(DoubleCell.class));
    			specs[i] = creator.createSpec();
    			continue;
    		}
    		
    		specs[i] = inData[0].getDataTableSpec().getColumnSpec(i);
    	}

        DataTableSpec outputSpec = new DataTableSpec(specs);
        BufferedDataContainer container = exec.createDataContainer(outputSpec);
    	
        CloseableRowIterator iter = inData[0].iterator();
        
        while (iter.hasNext()) {
        	DataRow row = iter.next();
        	
        	container.addRowToTable(row);
        }
        
        container.close();
        
        // TODO: Return a BufferedDataTable for each output port 
        return new BufferedDataTable[]{ container.getTable() };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void reset() {
        // TODO: generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
            throws InvalidSettingsException {

        // TODO: generated method stub
        return new DataTableSpec[]{null};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveSettingsTo(final NodeSettingsWO settings) {
         // TODO: generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        // TODO: generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateSettings(final NodeSettingsRO settings)
            throws InvalidSettingsException {
        // TODO: generated method stub
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void loadInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {
        // TODO: generated method stub
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveInternals(final File internDir,
            final ExecutionMonitor exec) throws IOException,
            CanceledExecutionException {
        // TODO: generated method stub
    }

}

