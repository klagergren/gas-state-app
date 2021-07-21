import { TextField } from '@material-ui/core';
import FormControl from '@material-ui/core/FormControl';
import { makeStyles } from '@material-ui/core/styles';
import PropTypes from 'prop-types';
import { useSelector, useDispatch } from 'react-redux';
import { updateInput } from '../redux/slices/inputSlice';

const useStyles = makeStyles((theme) => ({
  formControl: {
    margin: theme.spacing(1),
    minWidth: 150,
    maxWidth: 350,
  },
  chips: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  chip: {
    margin: 2,
  },
  noLabel: {
    marginTop: theme.spacing(3),
  },
}));

const GasStateInput = ({ gasPropertyTypeId, gasPropertyTypeDisplay }) => {
  const classes = useStyles();

  const inputValue = useSelector((state) => state.inputs[gasPropertyTypeId]);
  const dispatch = useDispatch();

  function handleChange(e) {
    const payload = {
      inputType: gasPropertyTypeId,
      inputValue: e.target.value,
    };
    dispatch(updateInput(payload));
  }

  return (
    <div>
      <FormControl className={classes.formControl}>
        <TextField
          id={gasPropertyTypeId}
          label={gasPropertyTypeDisplay}
          variant="outlined"
          value={inputValue}
          onChange={handleChange}
        />
      </FormControl>
    </div>
  );
};

GasStateInput.propTypes = {
  gasPropertyTypeId: PropTypes.string.isRequired,
  gasPropertyTypeDisplay: PropTypes.string.isRequired,
};

export default GasStateInput;
