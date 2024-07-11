import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'

dayjs.extend(utc)
export function formatUTC(utcString, format = 'YYYY/MM/DD HH:mm:ss') {
    const resultTIem = dayjs.utc(utcString).utcOffset(8).format(format)
    return resultTIem
}

export function formatRestTime(fromDate, duration, unite='minute',format = 'HH时mm分ss秒') {
    const date1 = dayjs(fromDate).add(duration, unite)
    const date2 = dayjs()
    return dayjs(Math.max(0,date1.diff(date2))).utc().format(format)

}
