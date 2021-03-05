import { TextField } from '@material-ui/core';
import FormControl from '@material-ui/core/FormControl';
import { makeStyles } from '@material-ui/core/styles';
import PropTypes from 'prop-types';
import { useSelector, useDispatch } from 'react-redux';
import { updateTemperature } from '../redux/slices/temperatureSlice';

// import MenuItem from '@material-ui/core/MenuItem'

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

const GasStateInput = ({ gasPropertyType }) => {
  const classes = useStyles();

  const inputValue = useSelector((state) => state.value);
  const dispatch = useDispatch();

  function handleChange(e) {
    console.log('hello', e.target.value);
    dispatch(updateTemperature(e.target.value));
  }

  return (
    <div>
      <FormControl className={classes.formControl}>
        <TextField
          id="outlined-basic"
          label={gasPropertyType}
          variant="outlined"
          value={inputValue}
          onChange={handleChange}
        />
      </FormControl>
    </div>
  );
};

GasStateInput.propTypes = {
  gasPropertyType: PropTypes.string.isRequired,
};

export default GasStateInput;
