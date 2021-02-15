import { MenuItem, TextField } from '@material-ui/core'
import Select from '@material-ui/core/Select'
import FormControl from '@material-ui/core/FormControl'
import InputLabel from '@material-ui/core/InputLabel'
import {makeStyles} from '@material-ui/core/styles'
//import MenuItem from '@material-ui/core/MenuItem'

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

const gasPropertyOptions = [
  'Pressure', 
  'Temperature',
  'Energy',
  'Enthalpy',
]

const distanceUnits = [
  'meters',
  'cm',
  'mm',
  'inches',
]

const GasStateInput = () => {
  const classes = useStyles();
    return (
        <div>
            <FormControl className={classes.formControl}>
              <InputLabel>Property Type 1</InputLabel>
                <Select>
                  {gasPropertyOptions.map((gasProperty) => (
                    <MenuItem key={gasProperty} value={gasProperty}>
                      {gasProperty}
                    </MenuItem>
                  ))}
                </Select>
            </FormControl>
            <FormControl className={classes.formControl}>
            <TextField id="outlined-basic" label="First Property" variant="outlined"></TextField>
            </FormControl>
            <FormControl className={classes.formControl}>
              <InputLabel>Units</InputLabel>
              <Select>
                {distanceUnits.map((unit) => (
                  <MenuItem key={unit} value={unit}>
                    {unit}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
        </div>
    )
}

export default GasStateInput
