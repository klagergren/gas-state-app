import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import { useSelector } from 'react-redux';
import { addRow } from '../redux/slices/tableSlice';
import store from '../app/store';
import {
  DENSITY_CONSTANTS,
  ENERGY_CONSTANTS,
  ENTHALPY_CONSTANTS,
  ENTROPY_CONSTANTS,
  PRESSURE_CONSTANTS,
  SOUND_SPEED_CONSTANTS,
  TEMPERATURE_CONSTANTS,
} from '../constants/constants';

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

const rowHeaders = [
  'Index',
  TEMPERATURE_CONSTANTS.display,
  PRESSURE_CONSTANTS.display,
  DENSITY_CONSTANTS.display,
  ENTROPY_CONSTANTS.display,
  ENTHALPY_CONSTANTS.display,
  SOUND_SPEED_CONSTANTS.display,
  ENERGY_CONSTANTS.display,
];

export function updateTableRows(gasStateOutput) {
  console.log({ gasStateOutput });
  store.dispatch(addRow(gasStateOutput));
}

function GasStateTable() {
  const rows = useSelector((state) => state.table.rows);
  const classes = useStyles();
  return (
    <div>
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label="simple table">
          <TableHead>
            <TableRow>
              {rowHeaders.map((rowHeader) => (
                <TableCell align="right" key={rowHeader}>
                  {rowHeader}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow key={row.index}>
                <TableCell component="th" scope="row" align="center">
                  {row.index}
                </TableCell>
                <TableCell align="right">
                  {row[TEMPERATURE_CONSTANTS.id]}
                </TableCell>
                <TableCell align="right">
                  {row[PRESSURE_CONSTANTS.id]}
                </TableCell>
                <TableCell align="right">{row[DENSITY_CONSTANTS.id]}</TableCell>
                <TableCell align="right">{row[ENTROPY_CONSTANTS.id]}</TableCell>
                <TableCell align="right">
                  {row[ENTHALPY_CONSTANTS.id]}
                </TableCell>
                <TableCell align="right">
                  {row[SOUND_SPEED_CONSTANTS.id]}
                </TableCell>
                <TableCell align="right">{row[ENERGY_CONSTANTS.id]}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default GasStateTable;
