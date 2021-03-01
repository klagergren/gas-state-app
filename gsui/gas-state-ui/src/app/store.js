import { configureStore } from '@reduxjs/toolkit';
import temperatureReducer from '../redux/slices/temperatureSlice';

export default configureStore({
  reducer: {
    temperature: temperatureReducer,
  },
});
